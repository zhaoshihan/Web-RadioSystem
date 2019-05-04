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
    export default {
        props:{
            instance:Object,
        },
        data () {
            return {
                modal1: false
            }
        },
        methods: {
            ok () {
                this.$Message.info('Clicked ok');
            },
            cancel () {
                this.$Message.info('Clicked cancel');
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
