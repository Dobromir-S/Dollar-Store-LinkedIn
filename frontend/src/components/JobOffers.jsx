import React, { Component } from 'react';

const EMPLOYEE_API_BASE_URL = "http://localhost:8088/api/jobs";

 async function getEmployees(){
    console.log("stuff ")
    const response = await fetch(EMPLOYEE_API_BASE_URL);
    const data = await response.json();
  //   const result = [{company: "SAP", salary: "5"}]
  // //  console.log(data)
    console.log(data);
    return data;
}

class JobOffers extends Component {

    state = {
        json: []
    }

    test = function (){
        console.log(this.state.json)
    }

    async componentDidMount() {
        console.log("working")
        getEmployees().then(response => {
            this.setState({ json: response });
        });
    }

     render() {
        return (
            <div>
                <table>
                    <thead>
                    <th>First Name</th>
                    <th>Last Name</th>
                    </thead>
                    <tbody>
                    { this.state.json.map((data) => {
                        return (
                            <tr key={data}>
                                <td>{data.company}</td>
                                <td>{data.salary}</td>
                            </tr>
                        )
                    })}
                    </tbody>
                </table>
            </div>)
    }
}

function dostuff(state){
    console.log(state)
}


export default JobOffers