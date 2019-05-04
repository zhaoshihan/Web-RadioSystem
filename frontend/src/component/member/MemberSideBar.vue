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
                    <li><a @click="chooseOrderList">Orders</a></li>
                </ul>
            </li>
        </ul>
    </aside>
</template>

<script>
    export default {
        props:{
            cartList:Array,
        },
        computed: {
        },
        methods:{
            chooseProductDisplay(){
                this.$emit('changeBar', 'ProductDisplay')
            },
            chooseCart(){
                this.$emit('changeBar', 'Cart')
            },
            chooseOrderList(){
                this.$emit('changeBar', 'OrderList')
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
