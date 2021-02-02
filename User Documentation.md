# User Documentation for Dollar Store LinkedIn

This document lays out the functionality of the app from the user facing side.

## 1.Create Job Offer 

A user is able to create a new job offer by clicking the "Create" and specify the: 
company name, the title of the job, the salary for the job, the sphere for which 
the job is and the description of the job.

## 2.Apply to a Job Offer 

A user is able to apply to any of the Job Offers available by clicking "Apply" and filling
his first name, last name and phone for contact and finally pressing "Submit". The User
should then see the counter for "Applicants" increment by 1.

## 3.Retiring a Job Offer

A user is able to retire a job offer if he so pleases. This means that this offer is
no longer available for applications. Only press "Retire Offer", and the offer will
be removed from the table of offers.

## 4.Showing all the applicants for a Job Offer

A user is able to view all the people that applied to a Job Offer by pressing
"Show Applicants". A Modal will open listing all the applicants in a table with
their names and phone for contact.

## 5.Authentication (Out of Scope)

In the theoretical case where the application had authentication, we would have had 2
Roles:

1. "Applicant": this role would have been able to only apply to a Job Offer.
   
2. "Employer": this role would have been able to access all the other functionality,
but would not be able to apply to a job offer.