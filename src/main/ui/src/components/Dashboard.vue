<template>
  <div class="hello">
    <Header />
    <div class="container mrgnbtm">
      <div class="row">
        <div class="col-md-8">
          <CreateCustomer @createCustomer="customerCreate($event)" :companies="companies" />
        </div>
        <div class="col-md-4">
          <DisplayBoard :numberOfCustomers="numberOfCustomers" @getAllCustomers="getAllCustomers()" />
        </div>
      </div>
    </div>
    <div class="row mrgnbtm">
      <Customers v-if="customers.length > 0" @deleteCustomer="customerDelete($event)" :customers="customers" :companies="companies"/>
    </div>
    <div class="row mrgnbtm">
      <div class="container mrgnbtm">
        <button style="margin-right:15px" @click="saveAllCustomers(customers)" type="button" class="btn btn-info">Save all customers</button>
        <CSVButton @exportCSV="exportCSV()"/>
      </div>
    </div>
  </div>
</template>

<script>
import Header from './Header.vue'
import CreateCustomer from './CreateCustomer.vue'
import DisplayBoard from './DisplayBoard.vue'
import Customers from './Customers.vue'
const clonedeep = require('lodash.clonedeep')
import CSVButton from './CSVButton.vue'
import { getAllCustomers, getAllCompanies, createCustomer, 
  deleteCustomer, saveAllCustomers } from '../services/CustomerService'

export default {
    name: 'Dashboard',
    components: {
        Header,
        CreateCustomer,
        DisplayBoard,
        Customers,
        CSVButton
    },
    data() {
        return {
            customers: [],
            companies: [],
            companiesHelper: [],
            numberOfCustomers: 0
        }
    },
    methods: {
        getAllCustomers() {
            getAllCustomers().then(response => {
                console.log(response)
                this.customers = response.map(customer => {
                    customer.companies = customer.companies.split(",");
                    return customer;
                })
                this.numberOfCustomers = this.customers.length
            })
        },
        getAllCompanies() {
            getAllCompanies().then(response => {
                console.log(response)
                this.companies = response
                this.companies.map(company => {
                    this.companiesHelper[company.id] = company;
                })
            })
        },
        customerCreate(data) {
            let customerIds = [];
            let customerIdTaken = false;
            data.id = this.numberOfCustomers +1;    
            this.customers.map(customer => {
                customerIds.push(customer.id);
                if(!customerIdTaken) {if(customer.id == data.id) customerIdTaken = true;}  
            });
            customerIds = customerIds.sort();
            if(customerIdTaken) data.id = customerIds[customerIds.length-1] +1;
            data.companies = data.companies.toString();
            createCustomer(data).then(response => {
                console.log(response);
                this.getAllCustomers();
            });
        },
        customerDelete(user) {
            user.companies = user.companies.toString();
            deleteCustomer(user).then(response => {
                console.log(response);
                this.getAllCustomers();
            });
        },
        saveAllCustomers(customers) {
            customers.map(user => {
                user.companies = user.companies.toString();
                return user;
            });
            saveAllCustomers(customers).then(response => {
                console.log(response);
                this.getAllCustomers();
            });
        },
        exportCSV() {
            let csvContent = "data:text/csv;charset=utf-8,";
            let exportUsers = clonedeep(this.customers);
            exportUsers = exportUsers.map(user => {
                user.companies.map((company, index) => {
                    user.companies[index] = this.companiesHelper[company].name;
                    return company
                })
                return user;
            })
            csvContent += [
                Object.keys(exportUsers[0]).join(";"),
                ...exportUsers.map(item => Object.values(item).join(";"))
            ]
                .join("\n")
                .replace(/(^\[)|(\]$)/gm, "");
            const data = encodeURI(csvContent);
            const link = document.createElement("a");
            console.log("data", data);
            link.setAttribute("href", data);
            link.setAttribute("download", "customers.csv");
            link.click();
        }
    },
    mounted () {
        this.getAllCompanies();
        this.getAllCustomers();
    }
}
</script>