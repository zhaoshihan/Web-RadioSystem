<template>
    <div id="app">
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
    </div>
</template>

<script>
    import MemberList from '../component/MemberList.vue'
    import ProductList from '../component/ProductList'
    import Top from '../component/Top.vue'
    import SideBar from '../component/StaffSideBar.vue'

    export default {
        name: 'StaffHome',
        components:{
            Top,
            SideBar,
            MemberList,
            ProductList,
        },
        data () {
            return {
                currentView: 'ProductList',
            }
        },
        methods:{
            handleChangeBar:function (name) {
                this.currentView = name
            }
        }
    }
</script>

<style scoped>

</style>
