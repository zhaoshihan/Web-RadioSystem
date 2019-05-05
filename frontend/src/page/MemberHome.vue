<template>
    <div class="container">
        <top></top>
        <div class="columns">
            <div class="column is-one-fifth">
                <side-bar @changeBar="handleChangeBar" :cart-list="cartList"></side-bar>
            </div>
            <div class="column">
                <component :is="currentView" :product-list="productList" :cart-list="cartList" @cleanCartList="handleCleanCartList"></component>
            </div>
        </div>
    </div>
</template>

<script>
    import Top from '../component/common/Top'
    import SideBar from '../component/member/MemberSideBar'
    import ProductDisplay from '../component/member/ProductDisplay'
    import Cart from '../component/member/Cart'
    import Axios from 'axios'

    export default {
        components:{
            Top,
            SideBar,
            ProductDisplay,
            Cart,
        },
        mounted () {
            Axios({
                method: 'get',
                url: '/product/query/all',
                baseURL: 'http://localhost:8082',
            }).then(response=> {
                console.log(response)
                this.productList = response.data
            }).catch(error=>{
                console.warn(error)
                alert(error)
            })
        },
        data(){
            return{
                currentView: 'ProductDisplay',
                productList: [],
                cartList: [],
            }
        },
        methods:{
            handleChangeBar:function (name) {
                this.currentView = name;
            },
            handleCleanCartList:function () {
                this.cartList = []
            }
        }

    }
</script>

<style scoped>

</style>
