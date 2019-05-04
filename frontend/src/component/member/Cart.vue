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
                        应付总额 <span class="tag is-white is-large">¥ {{ costAll - promotion }}</span>
                        <span v-if="promotion">
                            （优惠 <span class="tag is-white is-large">¥ {{ promotion }}</span>）
                            </span>
                    </p>
                    <p class="level-item">
                        <button class="button is-info" @click="handleOrder">现在结算</button>
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
    export default {
        props:{
            cartList:Array,
            productList:Array,
        },
        computed: {
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
                    cost += this.productDictList[item.id].cost * item.count;
                });
                return cost;
            }
        },
        data () {
            return {
                // productList: product_data,
                promotionCode: '',
                promotion: 100
            }
        },
        methods: {
            handleCount (index, count) {
                if (count < 0 && this.cartList[index].count === 1) return;
                let payload = {
                    id: this.cartList[index].id,
                    count: count
                }
                this.editCartCount(payload)
            },
            editCartCount (payload) {
                const product = this.cartList.find(item => item.id === payload.id);
                product.count += payload.count;
            },

            handleDelete (index) {
                this.deleteCart(this.cartList[index].id)
            },
            deleteCart (id) {
                const index = this.cartList.findIndex(item => item.id === id);
                this.cartList.splice(index, 1);
            },

            handleCheckCode () {
                if (this.promotionCode === '') {
                    window.alert('请输入优惠码');
                    return;
                }
                if (this.promotionCode !== 'Vue.js') {
                    window.alert('优惠码验证失败');
                } else {
                    this.promotion = 500;
                }
            },
            handleOrder () {
                // 真实环境应通过 ajax 提交购买请求后再清空购物列表
                return new Promise(resolve=> {
                    setTimeout(() => {
                        this.emptyCart()
                        resolve();
                    }, 500)
                });
            },
            emptyCart () {
                this.cartList = [];
            }
        }
    }
</script>

<style scoped>

</style>
