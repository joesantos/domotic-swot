import React from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Home from "./pages/Home";
import NewIndividualForm from "./pages/NewIndividualForm";

export default function App() {
  return (
    <Router>
      <div>
        <Switch>
          <Route path="/">
            <Home />
          </Route>
          <Route
            path="/newIndividual"
            component={NewIndividualForm}
            render={NewIndividualForm}
          >
            <NewIndividualForm />
          </Route>
        </Switch>
      </div>
    </Router>
  );
}
