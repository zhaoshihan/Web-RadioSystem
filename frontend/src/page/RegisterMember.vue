<template>
    <section class="hero is-light is-fullheight">
        <div class="hero-body">
            <div class="container has-text-centered">
                <div class="column is-4 is-offset-4">
                    <h3 class="title has-text-grey">Register</h3>
                    <p class="subtitle has-text-grey">Please register to proceed.</p>
                    <div class="box">
                        <form v-on:submit.prevent>
                            <div class="field">
                                <label class="label has-text-left">ID：</label>
                                <div class="control">
                                    <input class="input" v-model="memberInstance.id" type="number" placeholder="Your ID">
                                </div>
                            </div>

                            <div class="field">
                                <label class="label has-text-left">Name：</label>
                                <div class="control">
                                    <input class="input" v-model="memberInstance.name" type="text" placeholder="Your Name">
                                </div>
                            </div>

                            <div class="field">
                                <div class="control">
                                    <label class="radio">
                                        <input type="radio" v-model="memberInstance.gender" value="m">
                                        Gentlemen
                                    </label>
                                    <label class="radio">
                                        <input type="radio" v-model="memberInstance.gender" value="f">
                                        Lady
                                    </label>
                                </div>
                            </div>

                            <div class="field">
                                <label class="label has-text-left">City：</label>
                                <div class="control">
                                    <input class="input" v-model="memberInstance.city" type="text" placeholder="Your City">
                                </div>
                            </div>

                            <div class="field">
                                <label class="label has-text-left">Address：</label>
                                <div class="control">
                                    <input class="input" v-model="memberInstance.address" type="text" placeholder="Your Address">
                                </div>
                            </div>

                            <div class="field">
                                <label class="label has-text-left">PostCode：</label>
                                <div class="control">
                                    <input class="input" v-model="memberInstance.postCode" type="text" placeholder="Your PostCode">
                                </div>
                            </div>

                            <div class="field">
                                <label class="label has-text-left">PhoneNumber：</label>
                                <div class="control">
                                    <input class="input" v-model="memberInstance.phoneNumber" type="tel" placeholder="Your PhoneNumber">
                                </div>
                            </div>

                            <div class="field">
                                <label class="label has-text-left">Email：</label>
                                <div class="control">
                                    <input class="input" v-model="memberInstance.email" type="email" placeholder="Your Email">
                                </div>
                            </div>

                            <div class="field">
                                <label class="label has-text-left">Account：</label>
                                <div class="control">
                                    <input class="input" v-model="memberInstance.account" type="text" placeholder="Your Account">
                                </div>
                            </div>

                            <div class="field">
                                <label class="label has-text-left">Password：</label>
                                <div class="control">
                                    <input class="input" v-model="memberInstance.password" type="password" placeholder="Your Password">
                                </div>
                            </div>
                            <button class="button is-block is-info is-fullwidth" @click="addMember">Register</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>

</template>

<script>
    import Axios from 'axios';
    Axios.defaults.headers.post['Content-Type'] = 'application/json';

    export default {
        data(){
            return{
                memberInstance: {
                    id: '',
                    name: '',
                    gender: '',
                    city: '',
                    address: '',
                    postCode: '',
                    phoneNumber: '',
                    email: '',
                    account:'',
                    password:'',
                }
            }
        },
        methods:{
            validateForm:function(){
                if (typeof this.memberInstance.id == "undefined" ||
                    this.memberInstance.id == null ||
                    this.memberInstance.id === "") {
                    alert("id is null!")
                    return false;
                }
                if (typeof this.memberInstance.name == "undefined" ||
                    this.memberInstance.name == null ||
                    this.memberInstance.name === "") {
                    alert("name is null!")
                    return false;
                }
                if (typeof this.memberInstance.gender == "undefined" ||
                    this.memberInstance.gender == null ||
                    this.memberInstance.gender === "") {
                    alert("gender is null!")
                    return false;
                }
                if (typeof this.memberInstance.city == "undefined" ||
                    this.memberInstance.city == null ||
                    this.memberInstance.city === "") {
                    alert("city is null!")
                    return false;
                }
                if (typeof this.memberInstance.address == "undefined" ||
                    this.memberInstance.address == null ||
                    this.memberInstance.address === "") {
                    alert("address is null!")
                    return false;
                }
                if (typeof this.memberInstance.postCode == "undefined" ||
                    this.memberInstance.postCode == null ||
                    this.memberInstance.postCode === "") {
                    alert("postcode is null!")
                    return false;
                }
                if (typeof this.memberInstance.phoneNumber == "undefined" ||
                    this.memberInstance.phoneNumber == null ||
                    this.memberInstance.phoneNumber === "") {
                    alert("phonenumber is null!")
                    return false;
                }
                if (typeof this.memberInstance.email == "undefined" ||
                    this.memberInstance.email == null ||
                    this.memberInstance.email === "") {
                    alert("email is null!")
                    return false;
                }
                // let emailPattern = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/
                // if(!emailPattern.test(this.memberInstance.email)){
                //     alert("email is not valid!")
                //     return false;
                // }
                if (typeof this.memberInstance.account == "undefined" ||
                    this.memberInstance.account == null ||
                    this.memberInstance.account === "") {
                    alert("account is null!")
                    return false;
                }
                if (typeof this.memberInstance.password == "undefined" ||
                    this.memberInstance.password == null ||
                    this.memberInstance.password === "") {
                    alert("password is null!")
                    return false;
                }
                return true;
            },
            cleanForm:function(){
                this.memberInstance.id = ''
                this.memberInstance.name = ''
                this.memberInstance.gender = ''
                this.memberInstance.city = ''
                this.memberInstance.address = ''
                this.memberInstance.postCode = ''
                this.memberInstance.phoneNumber = ''
                this.memberInstance.email = ''
                this.memberInstance.account = ''
                this.memberInstance.password = ''
            },
            addMember:function () {
                if(this.validateForm()){
                    console.log("addMember function: " + this.memberInstance)
                    alert(this.memberInstance)
                    Axios({
                        method: 'post',
                        url: '/member/add',
                        baseURL: 'http://localhost:8082',
                        data: this.memberInstance
                    }).then(response=> {
                        console.log("In then method")
                        console.log(response)
                        alert("register success")
                        this.$router.push('/login')
                    }).catch(error=>{
                        console.warn("In catch method")
                        console.warn(error)
                        alert(error)
                        this.cleanForm()
                    })
                }
            }
        }

    }
</script>

<style scoped>

</style>
