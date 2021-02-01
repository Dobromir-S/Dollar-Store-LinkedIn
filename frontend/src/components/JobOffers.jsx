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
let firstname = ''
let lastname = ''
let company = ''
let title = ''
let salary = ''
let sphere = ''
let desc = ''
let id = 1;

async function getEmployees(){
    const response = await fetch(EMPLOYEE_API_BASE_URL);
    const result = await response.json();

     // const result = [{"id":3,"company":"SAP","title":"janitor","type":"IT","description":"Be Zobi","salary":5,
     // "applicants":[{"id":1,"fristName":"Zobi","last_name":"McZobFace"}]},
     // {"id":5,"company":"ChadChad","title":"ChadChad","type":"IT","description":"Be chad","salary":99999999,"applicants":[]},
     // {"id":7,"company":"basic","title":"basic","type":"Useless","description":"Be basic","salary":1,"applicants":[]}]

    return result;
}

class JobOffers extends Component {

    constructor() {
        super();
        this.openModal = this.openModal.bind(this);
        this.openModal2 = this.openModal2.bind(this);
        this.closeModal = this.closeModal.bind(this);
        this.closeModal2 = this.closeModal2.bind(this);

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleCreate = this.handleCreate.bind(this);

    }

    openModal(data) {
        console.log(data)
        id = data.id;
        this.setState({modalIsOpen: true});
    }

    openModal2() {
        this.setState({modal2IsOpen: true});
    }

    closeModal2() {
        this.setState({modal2IsOpen: false});
    }

    closeModal() {
        this.setState({modalIsOpen: false});
    }

    handleChange(event) {
        firstname = event.target.value;
        console.log(firstname)
    }

    handleChange2(event) {
        lastname = event.target.value;
        console.log(lastname);
    }

    handleCompany(event) {
        company = event.target.value;
    }

    handleTitle(event) {
        title = event.target.value;
    }

    handleSalary(event) {
        salary = event.target.value;
    }

    handleSphere(event) {
        sphere = event.target.value;
    }

    handleDesc(event) {
        desc = event.target.value;
    }

    handleCreate(event) {
        console.log("hey")
        this.closeModal2();
        this.createJob();
        event.preventDefault();

    }

    createJob(){
        console.log("test")
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ company: company, title: title, salary: salary, description: desc, type: sphere})
        };
        const response = fetch('http://localhost:8088/api/jobs', requestOptions);
    }

    handleSubmit(event) {
        this.closeModal();
        this.applyToJob();
        event.preventDefault();
    }

    async applyToJob(){
        console.log("test")
        const url = 'http://localhost:8088/api/jobs/apply/' + id;
        console.log(url)
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ firstName: firstname, lastName: lastname })
        };
        const response = await fetch('http://localhost:8088/api/jobs/apply/' + id, requestOptions);
    }



    state = {
        modalIsOpen: false,
        modal2IsOpen: false,
        json: [],
        test: ''
    }

    async componentDidMount() {
        this.timer = setInterval(()=> getEmployees().then(response => {
            this.setState({ json: response });
        }), 1000);
    }

     render() {
        return (
            <div>
                <Button
                    onClick={() => this.openModal2()}
                    style={{
                        color: "white",
                        background: "lightblue",
                        margin: 20,
                    }}
                >
                    Create
                </Button>
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
                                onClick={() => this.openModal(data)}
                                style={{
                                           color: "white",
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
                               color: "white",
                               background: "white",
                               margin: 20
                           }}
                    >
                  <div>
                      <h3>Apply for Job</h3>
                      <form onSubmit={this.handleSubmit}>
                        <label>
                          First Name:
                          <input type="text" value={this.state.value} onChange={this.handleChange} />
                        </label>
                        <br/>
                        <label>
                          Last Name:
                          <input type="text" value={this.state.value} onChange={this.handleChange} />
                        </label>
                        <br/>
                        <label>
                          Phone:
                          <input type="text" onChange={this.handleChange2} />
                        </label>
                        <br/>
                        <input type="submit" value="Submit" />
                      </form>
                  </div>
                </Modal>

                <Modal
                    open={this.state.modal2IsOpen}
                    isOpen={this.state.modal2IsOpen}
                    onClose={this.closeModal2}
                    style={{
                        color: "white",
                        background: "white",
                        margin: 20
                    }}
                >
                    <div>
                        <h3>Create Job</h3>
                        <form onSubmit={this.handleCreate}>
                            <label>
                                company:
                                <input type="text" onChange={this.handleCompany} />
                            </label>
                            <br/>
                            <label>
                                title:
                                <input type="text" onChange={this.handleTitle} />
                            </label>
                            <br/>
                            <label>
                                salary:
                                <input type="text" onChange={this.handleSalary} />
                            </label>
                            <br/>
                            <label>
                                sphere:
                                <input type="text" onChange={this.handleSphere} />
                            </label>
                            <br/>
                            <label>
                                description:
                                <input type="text" onChange={this.handleDesc} />
                            </label>
                            <br/>
                            <input type="submit" value="Create" />
                        </form>
                    </div>
                </Modal>
            </div>
            )
    }
}

export default JobOffers