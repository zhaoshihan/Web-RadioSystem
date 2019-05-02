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
                    <user-list></user-list>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import UserList from '../component/MemberList.vue'
    import AddUser from '../component/AddUser.vue'
    import Top from '../component/Top.vue'
    import SideBar from '../component/SideBar.vue'

    export default {
        name: 'StaffHome',
        components:{Top,UserList,AddUser,SideBar},
        data () {
            return {

            }
        }
    }
</script>

<style scoped>

</style>
