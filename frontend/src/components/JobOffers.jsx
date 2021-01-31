import React, { Component } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import Button from '@material-ui/core/Button';
import Modal from '@material-ui/core/Modal';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';

interface jobOffer {
    id: number,
    company: string,
    title: string,
    type: string,
    description: string,
    salary: string,
    applicants: [],
}

interface Applicant {
    id: number,
    fristName: string,
    last_name: string,
}

const EMPLOYEE_API_BASE_URL = "http://localhost:8088/api/jobs";

async function getEmployees(){
    //const response = await fetch(EMPLOYEE_API_BASE_URL);
    //const data = await response.json();

     const result = [{"id":3,"company":"SAP","title":"janitor","type":"IT","description":"Be Zobi","salary":5,
     "applicants":[{"id":1,"fristName":"Zobi","last_name":"McZobFace"}]},
     {"id":5,"company":"ChadChad","title":"ChadChad","type":"IT","description":"Be chad","salary":99999999,"applicants":[]},
     {"id":7,"company":"basic","title":"basic","type":"Useless","description":"Be basic","salary":1,"applicants":[]}]

    return result;
}

class JobOffers extends Component {

    constructor() {
        super();
        this.openModal = this.openModal.bind(this);
        this.closeModal = this.closeModal.bind(this);
    }

    openModal() {
        this.setState({modalIsOpen: true});
    }

    closeModal() {
        this.setState({modalIsOpen: false});
    }

    state = {
        modalIsOpen: false,
        json: []
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
                        <TableCell align="right">Description</TableCell>
                        <TableCell align="right">Applicants</TableCell>
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
                          <TableCell align="right">{data.description}</TableCell>
                          <TableCell align="right">{data.applicants.length}</TableCell>

                              <Button
                                onClick={() => this.openModal()}
                                style={{
                                           color: "black",
                                           background: "lightblue",
                                           margin: 20,
                                       }}
                              >
                                Apply
                            </Button>

                        </TableRow>
                      ))}
                    </TableBody>
                  </Table>
                </TableContainer>

                <Modal
                    open={this.state.modalIsOpen}
                    isOpen={this.state.modalIsOpen}
                    onClose={this.closeModal}
                    style={{
                               color: "black",
                               background: "lightblue",
                               margin: 20,
                           }}
                    >
                  <div>
                    <h3>Apply for Job</h3>
                    <p>First Name</p>
                    <p>Last Name</p>
                    <p>Phone Number</p>
                  </div>
                </Modal>
            </div>
            )
    }
}

export default JobOffers