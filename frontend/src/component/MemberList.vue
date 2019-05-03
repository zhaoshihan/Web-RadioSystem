<template>
            <div class="panel">
                <!-- Default panel contents -->
                <div class="panel-heading">用户列表</div>
                <!-- Table -->
                <table id ="user_tb" class="table">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Gender</th>
                        <th>PhoneNumber</th>
<!--                        <th>Email</th>-->
<!--                        <th>PostCode</th>-->
<!--                        <th>City</th>-->
<!--                        <th>Address</th>-->
                        <th>Account</th>
                        <th>Password</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr v-for="member in memberList" :id="member.id">
                        <td>{{member.id}}</td>
                        <td>{{member.name}}</td>
                        <td>{{showGender(member.gender)}}</td>
                        <td>{{member.phoneNumber}}</td>
<!--                        <td>{{member.email}}</td>-->
<!--                        <td>{{member.postCode}}</td>-->
<!--                        <td>{{member.city}}</td>-->
<!--                        <td>{{member.address}}</td>-->
                        <td>{{member.account}}</td>
                        <td>{{member.password}}</td>
                        <td><detail-modal :instance="member"></detail-modal></td>
                        <td><update-modal :instance="member"></update-modal></td>
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
import Axios from 'axios';
import detailModal from './DetailsModal'
import updateModal from './UpdateModal'
import deleteModal from './DeleteModal'
import AddModal from "./AddModal";

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
                id: 0,
                name: '',
                gender: '',
                phoneNumber: '',
                email: '',
                postCode: '',
                city: '',
                address: '',
                account: '',
                password: '',
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
        })
    },
    methods:{
        deleteMember:function(id){
             Axios.delete("http://localhost:8082/rest/member/"+id).then(response=>{
                console.log(response)
             });
        },
        showGender:function (gender) {
            console.log(gender)
            console.log(typeof gender)

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
