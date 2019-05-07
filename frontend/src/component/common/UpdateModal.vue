<template>
    <div class="test-modal">
        <button class="button is-primary" @click="modal1 = true">Update</button>
        <i-modal
                v-model="modal1"
                title="Update of Data"
                @on-ok="ok"
                @on-cancel="cancel">
            <div class="level" v-for="(value, key, index) in copyInstance">
                <div class="level-left">
                    <p class="level-item subtitle">{{key}}:</p>
                </div>
                <div class="level-right">
                    <p v-if="key === 'id'" class="level-item subtitle">{{value}}</p>
                    <input v-else-if="value instanceof Number" type="number" v-model="copyInstance[key]" class="input">
                    <input v-else-if="value instanceof Date" type="date" v-model="copyInstance[key]" class="input">
                    <input v-else type="text" v-model="copyInstance[key]" class="input">
                </div>
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
        data () {
            return {
                modal1: false,
                newInstance: {},
            }
        },
        computed:{
            copyInstance:function(){
                return Object.assign(this.newInstance, this.instance)
            }
        },
        methods: {
            ok () {
                console.log(this.newInstance)
                alert(this.newInstance)
                if(this.target === 'member'){
                    Axios({
                        method: 'post',
                        url: '/member/update',
                        baseURL: 'http://localhost:8082',
                        data: this.newInstance
                    }).then(response=> {
                        console.log("In then method")
                        console.log(response)
                        alert("update success")
                    }).catch(error=>{
                        console.warn("In catch method")
                        console.warn(error)
                        alert(error)
                    })
                }
                else if(this.target === 'product'){
                    Axios({
                        method: 'post',
                        url: '/product/update',
                        baseURL: 'http://localhost:8082',
                        data: this.newInstance
                    }).then(response=> {
                        console.log("In then method")
                        console.log(response)
                        alert("update success")
                    }).catch(error=>{
                        console.warn("In catch method")
                        console.warn(error)
                        alert(error)
                    })
                }
                else if(this.target === 'order'){
                    Axios({
                        method: 'post',
                        url: '/order/update',
                        baseURL: 'http://localhost:8082',
                        data: this.newInstance
                    }).then(response=> {
                        console.log("In then method")
                        console.log(response)
                        alert("update success")
                    }).catch(error=>{
                        console.warn("In catch method")
                        console.warn(error)
                        alert(error)
                    })
                }
                else{
                    alert("target error!")
                }
            },
            cancel () {
                // this.$Message.info('Clicked cancel');
            }
        }
    }
</script>

<style scoped>

</style>
