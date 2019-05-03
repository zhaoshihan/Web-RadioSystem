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
                                    <input class="input" v-model="staffInstance.id" type="number" placeholder="Your ID">
                                </div>
                            </div>

                            <div class="field">
                                <label class="label has-text-left">Name：</label>
                                <div class="control">
                                    <input class="input" v-model="staffInstance.name" type="text" placeholder="Your Name">
                                </div>
                            </div>

                            <div class="field">
                                <label class="label has-text-left">Account：</label>
                                <div class="control">
                                    <input class="input" v-model="staffInstance.account" type="text" placeholder="Your Account">
                                </div>
                            </div>

                            <div class="field">
                                <label class="label has-text-left">Password：</label>
                                <div class="control">
                                    <input class="input" v-model="staffInstance.password" type="password" placeholder="Your Password">
                                </div>
                            </div>
                            <button class="button is-block is-info is-fullwidth" @click="addStaff">Register</button>
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
                staffInstance:{
                    id: '',
                    name: '',
                    account: '',
                    password: '',
                }
            }
        },
        methods:{
            validateForm: function(){
                if (typeof this.staffInstance.id == "undefined" ||
                    this.staffInstance.id == null ||
                    this.staffInstance.id === "") {
                    alert("id is null!")
                    return false;
                }
                if (typeof this.staffInstance.name == "undefined" ||
                    this.staffInstance.name == null ||
                    this.staffInstance.name === "") {
                    alert("name is null!")
                    return false;
                }
                if (typeof this.staffInstance.account == "undefined" ||
                    this.staffInstance.account == null ||
                    this.staffInstance.account === "") {
                    alert("account is null!")
                    return false;
                }
                if (typeof this.staffInstance.password == "undefined" ||
                    this.staffInstance.password == null ||
                    this.staffInstance.password === "") {
                    alert("password is null!")
                    return false;
                }
                return true;
            },
            cleanForm:function(){
                this.staffInstance.id = ''
                this.staffInstance.name = ''
                this.staffInstance.account = ''
                this.staffInstance.password = ''
            },
            addStaff: function(){
                if(this.validateForm()){
                    console.log("addStaff function: " + this.staffInstance)
                    alert("addStaff function: " + this.staffInstance)
                    Axios({
                        method: 'post',
                        url: '/staff/add',
                        baseURL: 'http://localhost:8082',
                        data: this.staffInstance
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
