<template>
  <button @click='exportCSV()' type="button" class="btn btn-success">Export all customers to csv</button>
</template>

<script>

export default {
    name: 'Users',
    methods: {
        exportCSV() {
            this.$emit('exportCSV')
        }
    }
}
</script>