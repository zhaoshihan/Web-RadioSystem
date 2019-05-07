<template>
    <div class="test-modal">
        <button class="button is-danger" @click="modal2 = true">Delete</button>
        <i-modal v-model="modal2" width="360">
            <p slot="header" style="color:#f60;text-align:center">
                <Icon type="ios-information-circle"></Icon>
                <span>Delete confirmation</span>
            </p>
            <ul>
                <li v-for="(value, key, index) in instance">{{key}}: {{value}}</li>
            </ul>
            <div style="text-align:center">
                <p class="subtitle">Will you delete it?</p>
            </div>
            <div slot="footer">
                <Button type="error" size="large" long :loading="modal_loading" @click="del">Delete</Button>
            </div>
        </i-modal>
    </div>
</template>

<script>
    import Axios from 'axios'
    Axios.defaults.headers.post['Content-Type'] = 'application/json';

    export default {
        props:{
            instance:Object,
            target:String,
        },
        data(){
            return{
                modal2: false,
                modal_loading: false,
            }
        },
        methods:{
            del () {
                this.modal_loading = true;
                if(this.target === 'member'){
                    Axios({
                        method: 'post',
                        url: '/member/delete',
                        baseURL: 'http://localhost:8082',
                        data: this.instance
                    }).then(response=> {
                        console.log("In then method")
                        console.log(response)
                        alert("delete success")
                    }).catch(error=>{
                        console.warn("In catch method")
                        console.warn(error)
                        alert(error)
                    })
                }
                else if(this.target === 'product'){
                    Axios({
                        method: 'post',
                        url: '/product/delete',
                        baseURL: 'http://localhost:8082',
                        data: this.instance
                    }).then(response=> {
                        console.log("In then method")
                        console.log(response)
                        alert("delete success")
                    }).catch(error=>{
                        console.warn("In catch method")
                        console.warn(error)
                        alert(error)
                    })
                }
                else if(this.target === 'order'){
                    Axios({
                        method: 'post',
                        url: '/order/delete',
                        baseURL: 'http://localhost:8082',
                        data: this.instance
                    }).then(response=> {
                        console.log("In then method")
                        console.log(response)
                        alert("delete success")
                    }).catch(error=>{
                        console.warn("In catch method")
                        console.warn(error)
                        alert(error)
                    })
                }
                else{
                    alert("target error!")
                }
                this.modal_loading = false;
                this.modal2 = false;
            }
        }

    }
</script>

<style scoped>

</style>
