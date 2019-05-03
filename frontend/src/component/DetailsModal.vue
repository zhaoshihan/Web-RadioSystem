<template>
    <div class="test-modal">
        <button class="button" @click="modal1 = true">Details</button>
        <i-modal
                v-model="modal1"
                title="Details of Data"
                @on-ok="ok"
                @on-cancel="cancel">
                <div class="level" v-for="(value, key, index) in instance">
                    <div class="level-left">
                        <p class="level-item subtitle">{{key}}:</p>
                    </div>
                    <div class="level-right">
                        <p class="level-item subtitle">{{value}}</p>
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
        }
    }
</script>
<style scoped>

</style>
