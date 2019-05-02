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
                    <tr v-for="member in memberList" :key="memberList.id">
                        <td>{{member.id}}</td>
                        <td>{{member.name}}</td>
                        <td>{{member.gender}}</td>
                        <td>{{member.phoneNumber}}</td>
<!--                        <td>{{member.email}}</td>-->
<!--                        <td>{{member.postCode}}</td>-->
<!--                        <td>{{member.city}}</td>-->
<!--                        <td>{{member.address}}</td>-->
                        <td>{{member.account}}</td>
                        <td>{{member.password}}</td>
                        <td><button class="button">Details</button></td>
                        <td><button class ="button">Update</button></td>
                        <td><button class ="button is-primary" v-on:click="deleteMember(user.id)">Delete</button></td>
                    </tr>
                    </tbody>
                    <tfoot>
                        <button class ="button">Add</button>
                    </tfoot>
                </table>
            </div>
</template>

<script>
import Axios from 'axios';
import 'bulma/css/bulma.css'

export default {
    data(){
        return {
            memberInstance: {
                id: '',
                name: '',
                gender:'',
                phoneNumber:'',
                email:'',
                postCode:'',
                city:'',
                address:'',
                account:'',
                password:''
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
        }
    }

}
</script>

<style>

</style>
