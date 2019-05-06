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
    import MemberList from '../component/staff/MemberList.vue'
    import ProductList from '../component/staff/ProductList'
    import Top from '../component/common/Top.vue'
    import SideBar from '../component/staff/StaffSideBar.vue'

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
                currentView: 'MemberList',
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
