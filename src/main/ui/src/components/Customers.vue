<template>
  <div class="container">
    <h2>Customers</h2>
    <table class="table table-bordered">
      <thead>
        <tr>
          <th>Customer Id</th>
          <th>Firstname</th>
          <th>Lastname</th>
          <th>Address</th>
          <th>Companies</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in customers" :key="item.id">
          <td>{{ item.id }}</td>
          <td><input class="form-control" type="text" v-model="item.firstName" required></td>
          <td><input class="form-control" type="text" v-model="item.lastName" required></td>
          <td><input class="form-control" type="text" v-model="item.address" required></td>
          <!-- <td><input type="" v-model="item.companies" required></td> -->
          <td>
            <select class="select-form-style" v-model="item.companies" multiple>
              <option :value="company.id" v-for="company in companies" :key="company.id">
                {{ company.name }}
              </option>
            </select>
          </td>
          <td>
            <button style="margin-right: 10px;" @click="deleteCustomer(item)" type="submit" class="btn btn-danger">Delete</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
    

    export default {
        name: 'Customers',
        props: ['customers','companies'],
        methods: {
            deleteCustomer(customer) {
                this.$emit('deleteCustomer', customer);
            }
        }
     }
</script>