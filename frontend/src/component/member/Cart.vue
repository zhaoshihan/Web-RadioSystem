<template>
    <div class="panel">
        <!-- Default panel contents -->
        <div class="panel-heading">购物清单</div>
        <!-- Table -->
        <table class="table is-fullwidth">
            <thead>
            <tr>
                <th>商品信息</th>
                <th class="has-text-centered">单价</th>
                <th class="has-text-centered">数量</th>
                <th class="has-text-centered">小计</th>
                <th class="has-text-centered">删除</th>
            </tr>
            </thead>
            <tfoot>
                <tr class="level">
                    <p class="level-item">
                        共计 <span class="tag is-white is-large">{{ countAll }}</span> 件商品
                    </p>
                    <p class="level-item">
                        应付总额 <span class="tag is-white is-large">¥ {{ costAll }}</span>
                        <span v-if="hasDiscount">
                            （折后价 <span class="tag is-white is-large">¥ {{ discoutCostAll }}</span>）
                        </span>
                    </p>
                    <p class="level-item">
                        <button v-if="cartList.length" class="button is-info" @click="handleOrder">现在结算</button>
                    </p>
                </tr>
            </tfoot>
            <tbody>
                <tr v-for="(item, index) in cartList" :key="item.id">
                    <td>
                        <div class="tags">
                            <figure class="image is-24x24">
                                <img src="https://bulma.io/images/placeholders/24x24.png" alt="Image">
                            </figure>
                            <span class="has-text-left">{{ productDictList[item.id].name }}</span>
                        </div>
                    </td>
                    <td>
                        ¥ {{productDictList[item.id].price}}
                    </td>
                    <td>
                        <a class="tag is-rounded" @click="handleCount(index, -1)">-</a>
                        {{ item.count }}
                        <a class="tag is-rounded" @click="handleCount(index, 1)">+</a>
                    </td>
                    <td>
                        ¥ {{ productDictList[item.id].price * item.count }}
                    </td>
                    <td>
                        <a class="button is-danger is-small" @click="handleDelete(index)">Delete</a>
                    </td>
                </tr>
                <tr class="has-text-centered">
                    <td class="cart-empty" v-if="!cartList.length">购物车为空</td>
                    <td class="cart-promotion" v-show="cartList.length">
                        <label>使用优惠码：</label>
                        <input type="text" v-model="promotionCode">
                        <button class="button is-small is-info" @click="handleCheckCode">验证</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</template>
<script>
    import Axios from 'axios'
    Axios.defaults.headers.post['Content-Type'] = 'application/json';
    export default {
        computed: {
            cartList(){
                return this.$store.state.member.cartList
            },
            productList(){
                return this.$store.state.member.productList
            },
            hasDiscount(){
                return this.$store.state.member.hasDiscount
            },
            getMemberID(){
                return this.$store.state.global.currentUser['id']
            },
            getSendAddress(){
                return this.$store.state.global.currentUser['address']
            },
            productDictList () {
                const dict = {};
                this.productList.forEach(item => {
                    dict[item.id] = item;
                });
                return dict;
            },
            countAll () {
                let count = 0;
                this.cartList.forEach(item => {
                    count += item.count;
                });
                return count;
            },
            costAll () {
                let cost = 0;
                this.cartList.forEach(item => {
                    cost += this.productDictList[item.id].price * item.count;
                });
                return cost;
            },
            discoutCostAll(){
                let cost = 0;
                this.cartList.forEach(item =>{
                    cost += this.productDictList[item.id].discount * item.count;
                })
                return cost;
            }

        },
        data () {
            return {
                promotionCode: '',
                // orderInstance:{
                //     id:'',
                //     memberID:'',
                //     productID:'',
                //     amount:'',
                //     unitPrice:'',
                //     orderDate:'',
                //     sendDate:'',
                //     sendAddress:'',
                // }
            }
        },
        methods: {
            handleCount (index, count) {
                if (count < 0 && this.cartList[index].count === 1) return;
                this.$store.commit('editCartCount', {
                    id: this.cartList[index].id,
                    count: count
                });
            },
            handleDelete (index) {
                this.$store.commit('deleteCart', this.cartList[index].id);
            },
            handleCheckCode () {
                if (this.promotionCode === '') {
                    window.alert('请输入优惠码');
                    return;
                }
                if (this.promotionCode !== 'Vue.js') {
                    window.alert('优惠码验证失败');
                } else {
                    this.$store.commit('enjoyDiscount')
                }
            },
            handleOrder () {
                // 购买
                let requestList = []
                let timeStamp = (new Date()).valueOf() % 2147483648
                this.cartList.forEach(item => {
                    let newInstance = {}
                    newInstance['id'] = (timeStamp++) % 2147483648
                    newInstance['productID'] = item.id
                    newInstance['memberID'] = this.getMemberID
                    newInstance['orderDate'] = new Date()
                    newInstance['unitPrice'] = this.productDictList[item.id].price
                    newInstance['amount'] = item.count
                    newInstance['sendDate'] = new Date()
                    newInstance['sendAddress'] = this.getSendAddress
                    requestList.push(newInstance)
                });
                Axios({
                    method: 'post',
                    url: '/order/add',
                    baseURL: 'http://localhost:8082',
                    data: requestList
                }).then(response=> {
                    console.log("In then method")
                    console.log(response)
                    alert("orders add success")
                    this.$store.commit('emptyCart')
                }).catch(error=>{
                    console.warn("In catch method")
                    console.warn(error)
                    alert(error)
                })
            },
        }
    }
</script>

<style scoped>

</style>
