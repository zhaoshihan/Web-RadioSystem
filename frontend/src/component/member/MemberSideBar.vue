<template>
    <aside class="menu">
        <p class="menu-label">
            Member Home
        </p>
        <ul class="menu-list">
            <li>
                <a>Menu</a>
                <ul>
                    <li><a @click="chooseProductDisplay">Products</a></li>
                    <li><a @click="chooseCart">Cart&nbsp;<span v-if="cartList.length" class="tag">{{cartList.length}}</span></a></li>
                    <li><a @click="chooseOwnOrder">Orders</a></li>
                </ul>
            </li>
        </ul>
    </aside>
</template>

<script>
    export default {
        computed: {
            cartList(){
                return this.$store.state.member.cartList
            }
        },
        methods:{
            chooseProductDisplay(){
                this.$emit('changeBar', 'ProductDisplay')
            },
            chooseCart(){
                this.$emit('changeBar', 'Cart')
            },
            chooseOwnOrder(){
                this.$emit('changeBar', 'OwnOrder')
            }
        }
    }
</script>

<style scoped>
    .tag{
        background-color: #f2352e;
        border: 1px solid #f2352e;
        color: #fff;
    }
</style>
