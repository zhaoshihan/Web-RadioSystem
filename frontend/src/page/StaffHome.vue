<template>
    <div id="app">
        <div class="container">
            <top></top>
            <div class="columns">
                <div class="column is-one-fifth">
                    <side-bar></side-bar>
                </div>
                <div class="column">

<!--                    <router-view></router-view>-->
                    <product-list></product-list>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import MemberList from '../component/MemberList.vue'
    import ProductList from '../component/ProductList'
    import Top from '../component/Top.vue'
    import SideBar from '../component/SideBar.vue'

    export default {
        name: 'StaffHome',
        components:{
            Top,
            MemberList,
            ProductList,
            SideBar,
        },
        data () {
            return {

            }
        }
    }
</script>

<style scoped>

</style>
