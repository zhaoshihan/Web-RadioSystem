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
                    <input v-else-if="value instanceof Number" type="number" v-model="newInstance[key]" class="input">
                    <input v-else-if="value instanceof Date" type="date" v-model="newInstance[key]" class="input">
                    <input v-else type="text" v-model="newInstance[key]" class="input">
                </div>
            </div>
        </i-modal>
    </div>
</template>

<script>
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
                // let temp = this.instance
                // this.newInstance = {...temp}
                return Object.assign(this.newInstance, this.instance)
                // return this.newInstance
            }
        },
        methods: {
            ok () {
                console.log(this.newInstance)
                alert(this.newInstance)
                // Axios({
                //     method: 'post',
                //     url: '/' + this.target +'/update',
                //     baseURL: 'http://localhost:8082',
                //     data: this.newInstance
                // }).then(response=> {
                //     console.log("In then method")
                //     console.log(response)
                //     alert("register success")
                //     this.$Message.info('Clicked ok');
                // }).catch(error=>{
                //     console.warn("In catch method")
                //     console.warn(error)
                //     alert(error)
                //     this.$Message.info('Clicked cancel');
                // })

            },
            cancel () {
                this.$Message.info('Clicked cancel');
            }
        }
    }
</script>

<style scoped>

</style>
