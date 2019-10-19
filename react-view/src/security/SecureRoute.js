import React from "react";
import { Route, Redirect } from "react-router-dom";
import { connect } from "react-redux";
import PropTypes from "prop-types";

const SecureRoute = ({component:Component ,security,...otherProps}) => (
    <Route {...otherProps} render ={prop => }
    
    />
);

const mapStateToProps = state => ({});

const mapDispatchToProps = {};

export default connect(mapStateToProps)(SecureRoute);
