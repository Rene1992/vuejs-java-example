<template>
  <div class="display-board">
    <h4>Customers Count</h4>
    <div class="number">
      {{numberOfCustomers}}
    </div>
  </div>
</template>

<script>
    export default {
        name: 'DisplayBoard',
        props: ['numberOfCustomers'],
        methods: {
            getAllCustomers() {
                this.$emit('getAllCustomers')
            }
        }
    }
</script>