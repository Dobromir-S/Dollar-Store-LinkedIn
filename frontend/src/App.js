import logo from './logo.svg';
import './App.css';
import axios from "axios";
import React from "react";
const EMPLOYEE_API_BASE_URL = "http://localhost:8088/api/jobs";

async function getEmployees(){
  console.log("stuff ")
  const response = await fetch(EMPLOYEE_API_BASE_URL);
  const data = await response.json();
  console.log(data)
}

function App() {
  return (
    <div className="App">
        <button className="btn btn-primary" onClick={getEmployees}> Add Employee</button>
    </div>
  );
}

export default App;
