<template>
    <div class="test-modal">
        <button class="button is-success" @click="modal1 = true">Add</button>
        <i-modal
                v-model="modal1"
                title="Add of Data"
                @on-ok="ok"
                @on-cancel="cancel">
            <div class="level" v-for="(value,key,index) in instance">
                <div class="level-left">
                    <p class="level-item subtitle">{{key}}:</p>
                </div>
                <div class="level-right">
                    <input v-if="value === 'Number'" type="number" class="input" v-model="instance[key]">
                    <input v-else-if="value === 'Date'" type="date" class="input" v-model="instance[key]" >
                    <input v-else type="text" class="input" v-model="instance[key]">
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
                modal1: false
            }
        },
        methods: {
            ok () {
                if(this.target === 'member'){
                    Axios({
                        method: 'post',
                        url: '/member/add',
                        baseURL: 'http://localhost:8082',
                        data: this.instance
                    }).then(response=> {
                        console.log("In then method")
                        console.log(response)
                        alert("add success")
                    }).catch(error=>{
                        console.warn("In catch method")
                        console.warn(error)
                        alert(error)
                    })
                }
                else if(this.target === 'product'){
                    Axios({
                        method: 'post',
                        url: '/product/add',
                        baseURL: 'http://localhost:8082',
                        data: this.instance
                    }).then(response=> {
                        console.log("In then method")
                        console.log(response)
                        alert("add success")
                    }).catch(error=>{
                        console.warn("In catch method")
                        console.warn(error)
                        alert(error)
                    })
                }
                else if(this.target === 'order'){
                    Axios({
                        method: 'post',
                        url: '/order/add',
                        baseURL: 'http://localhost:8082',
                        data: this.instance
                    }).then(response=> {
                        console.log("In then method")
                        console.log(response)
                        alert("add success")
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
        },
        computed: {
            // nowDate:function() {
            //     return Date()
            // }
        }
    }
</script>

<style scoped>

</style>
