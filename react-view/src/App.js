import React, { Component } from "react";
import "./App.css";

import { BrowserRouter as Router, Route } from "react-router-dom";
import Header from "./components/Layout/Header";
import DashBoard from "./components/DashBoard/DashBoard";
import "bootstrap/dist/css/bootstrap.min.css";
import Landing from "./components/Layout/Landing";
import Login from "./components/UserManagement/Login";
import Register from "./components/UserManagement/Register";
import { Provider } from "react-redux";
import store from "./store";

class App extends Component {
  render() {
    return (
      <Provider store={store}>
        <Router>
          <div className="App">
            <Header />
            <Route exact path="/" component={Landing} />
            <Route exact path="/login" component={Login} />
            <Route exact path="/register" component={Register} />

            {
              //private routes
            }
          </div>
        </Router>
      </Provider>
    );
  }
}

export default App;
