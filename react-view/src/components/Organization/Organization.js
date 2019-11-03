import React, { Component } from "react";
import CreateOrganizationForm from "../Organization/CreateOrganizationForm";

class Organization extends Component {
  render() {
    return (
      <div>
        <h1>at org page</h1>
        <br />
        <CreateOrganizationForm />
        <br />
      </div>
    );
  }
}

export default Organization;
