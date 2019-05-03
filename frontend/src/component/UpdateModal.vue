<template>
    <div class="test-modal">
        <button class="button is-primary" @click="modal1 = true">Update</button>
        <i-modal
                v-model="modal1"
                title="Update of Data"
                @on-ok="ok"
                @on-cancel="cancel">
            <div class="level" v-for="(value, key, index) in instance">
                <div class="level-left">
                    <p class="level-item subtitle">{{key}}:</p>
                </div>
                <div class="level-right">
                    <p v-if="key === 'id'" class="level-item subtitle">{{value}}</p>
                    <input v-else type="text" class="input" :id="key" :name="key" :placeholder="value">
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
