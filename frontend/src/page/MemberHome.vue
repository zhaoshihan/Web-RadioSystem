<template>
    <div class="container">
        <top></top>
        <div class="columns">
            <div class="column is-one-fifth">
                <side-bar @changeBar="handleChangeBar"></side-bar>
            </div>
            <div class="column">
                <component :is="currentView"></component>
            </div>
        </div>
    </div>
</template>

<script>
    import Top from '../component/common/Top'
    import SideBar from '../component/member/MemberSideBar'
    import ProductDisplay from '../component/member/ProductDisplay'
    import Cart from '../component/member/Cart'
    import OwnOrder from '../component/member/OwnOrder'
    import Axios from 'axios'

    export default {
        components:{
            Top,
            SideBar,
            ProductDisplay,
            Cart,
            OwnOrder,
        },
        mounted () {

        },
        data(){
            return{
                currentView: 'ProductDisplay',
            }
        },
        methods:{
            handleChangeBar:function (name) {
                this.currentView = name;
            },
        }

    }
</script>

<style scoped>

</style>
