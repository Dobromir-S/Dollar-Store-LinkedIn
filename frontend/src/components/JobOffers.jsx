import React, { Component } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';

const EMPLOYEE_API_BASE_URL = "http://localhost:8088/api/jobs";

 async function getEmployees(){
    //const response = await fetch(EMPLOYEE_API_BASE_URL);
    //const data = await response.json();

     const result = [{"id":3,"company":"SAP","title":"janitor","type":"IT","description":"Be Zobi","salary":5,
     "applicants":[{"id":1,"fristName":"Zobi","last_name":"McZobFace"}]},
     {"id":5,"company":"ChadChad","title":"ChadChad","type":"IT","description":"Be chad","salary":99999999,"applicants":[]},
     {"id":7,"company":"basic","title":"basic","type":"USELESS","description":"Be basic","salary":1,"applicants":[]}]

    return result;
}

function apply() {
  alert("You have applied to {some-offer}!");
}

class JobOffers extends Component {

    state = {
        json: []
    }

    test = function (){
        console.log(this.state.json)
    }

    async componentDidMount() {
        getEmployees().then(response => {
            this.setState({ json: response });
        });
    }

     render() {
        return (
            <div>
                <TableContainer component={Paper}>
                  <Table>
                    <TableHead>
                      <TableRow>
                        <TableCell>Company</TableCell>
                        <TableCell align="right">Title</TableCell>
                        <TableCell align="right">Salary</TableCell>
                        <TableCell align="right">Sphere</TableCell>
                        <TableCell align="right">Actions</TableCell>
                      </TableRow>
                    </TableHead>
                    <TableBody>
                      {this.state.json.map((data) => (
                        <TableRow key={data.title}>
                          <TableCell component="th" scope="row">
                            {data.company}
                          </TableCell>
                          <TableCell align="right">{data.title}</TableCell>
                          <TableCell align="right">{data.salary}</TableCell>
                          <TableCell align="right">{data.type}</TableCell>
                          <button onClick={apply}>Apply</button>
                        </TableRow>
                      ))}
                    </TableBody>
                  </Table>
                </TableContainer>
            </div>
            )
    }
}

export default JobOffers