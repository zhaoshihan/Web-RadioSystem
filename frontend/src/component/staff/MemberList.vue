<template>
    <div class="panel">
        <!-- Default panel contents -->
        <div class="panel-heading">Member Lists</div>
        <!-- Table -->
        <table id ="member_tb" class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Gender</th>
                <th>PhoneNumber</th>
                <th>Account</th>
                <th>Password</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="member in memberList" :key="member.id">
                <td>{{member.id}}</td>
                <td>{{member.name}}</td>
                <td>{{showGender(member.gender)}}</td>
                <td>{{member.phoneNumber}}</td>
                <td>{{member.account}}</td>
                <td>{{member.password}}</td>
                <td><detail-modal :instance="member"></detail-modal></td>
                <td><update-modal :instance="member" target="member"></update-modal></td>
                <td><delete-modal :instance="member"></delete-modal></td>
            </tr>
            </tbody>
            <tfoot>
                <tr><add-modal :instance="memberInstance"></add-modal></tr>
            </tfoot>
        </table>
    </div>
</template>

<script>
    import Axios from '_axios@0.18.0@axios/index';
    import detailModal from '../common/DetailsModal'
    import updateModal from '../common/UpdateModal'
    import deleteModal from '../common/DeleteModal'
    import AddModal from "../common/AddModal";

    export default {
        components:{
            AddModal,
            detailModal,
            updateModal,
            deleteModal,
        },
        data(){
            return {
                memberInstance: {
                    id: 'Number',
                    name: 'String',
                    gender: 'String',
                    phoneNumber: 'String',
                    email: 'String',
                    postCode: 'String',
                    city: 'String',
                    address: 'String',
                    account: 'String',
                    password: 'String',
                },
                memberList:[]
            }
        },
        mounted(){
            Axios({
                method: 'get',
                url: '/member/query/all',
                baseURL: 'http://localhost:8082',
            }).then(response=> {
                console.log(response)
                this.memberList = response.data
            }).catch(error=>{
                console.warn(error)
                alert(error)
            })
        },
        methods:{
            showGender:function (gender) {
                if (gender === 'm') {
                    return "Gentleman"
                }
                else if(gender === 'f') {
                    return "Lady"
                }
                else{
                    return 'Null'
                }
            }
        }
    }
</script>

<style>

</style>
