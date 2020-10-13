export async function getAllCustomers() {
    const response = await fetch('/api/customers');
    return await response.json();
}

export async function getAllCompanies() {
  const response = await fetch('/api/companies');
  return await response.json();
}

export async function createCustomer(data) {
    const response = await fetch(`/api/customer`, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(data)
    })
    return await response.json();
}

export async function deleteCustomer(customer) {
    const response = await fetch(`/api/delete_customer`, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(customer)
    })
    return await response.json();
}

export async function saveAllCustomers(customers) {
    const response = await fetch(`/api/save_all_customers`, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(customers)
    })
    return await response.json();
}