<template>
  <div class="container">
    <div class="row">
      <div class="col-md-7 mrgnbtm">
      <h2>Create Customer</h2>
        <form>
          <div class="row">
            <div class="form-group col-md-6">
              <label>First Name</label>
              <input type="text" class="form-control" v-model="firstName" name="firstname" id="firstname" aria-describedby="FirstNameHelp" placeholder="First Name" />
            </div>
            <div class="form-group col-md-6">
              <label>Last Name</label>
              <input type="text" class="form-control" v-model="lastName" name="lastname" id="lastname" placeholder="Last Name" />
            </div>
          </div>
          <div class="row">
            <div class="form-group col-md-6">
              <label>Address</label>
              <input type="text" class="form-control" v-model="address" name="address" id="address" aria-describedby="addressHelp" placeholder="Address" />
            </div>
            <div class="form-group col-md-6">
              <label>Companies</label>
              <select class="select-form-style" v-model="newCompanies" multiple>
                <option :value="company.id" v-for="company in companies" :key="company.id">
                  {{ company.name }}
                </option>
              </select>
            </div>
          </div>
          <input type="submit" value="Create" @click='createCustomer()' class="btn btn-success" />
        </form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
    name: 'CreateCustomer',
    props: ['companies'],
    data() {
        return {
            firstName: '',
            lastName: '',
            address: '',
            newCompanies: []
        }
    },
    methods: {
        createCustomer() {
            const payload = {
                firstName: this.firstName,
                lastName: this.lastName,
                address: this.address,
                companies: this.newCompanies
            }
            if(this.checkForm(payload)){
                this.$emit('createCustomer', payload)
                this.clearForm();
            } else alert("Please fill all fields!");
        },
        clearForm() {
            this.firstName = "";
            this.lastName = "";
            this.address = "";
            this.newCompanies = [];
        },
        checkForm(payload) {
            if(payload.firstName == "" || 
               payload.lastName == "" ||
               payload.address == "" ||
               payload.newCompanies == []) return false
            else return true   
        }
    }
}
</script>