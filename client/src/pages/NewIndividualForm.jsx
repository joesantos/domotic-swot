import { useFormik } from 'formik';
import React, { useState, useEffect } from 'react';

const NewIndividualForm = () => {
  const [classes, setClasses] = useState([]);

  async function getClasses() {
    const response = await fetch("http://localhost:8080/Classes/list");
    const responseJson = await response.json();
    setClasses(responseJson)
  }

  const formik = useFormik({
    initialValues: {
      individualName: '',
    },
    onSubmit: values => {
      alert(JSON.stringify(values, null, 2));
    },
  });

  useEffect(() => {
    if (classes.length === 0) getClasses();
  })

  return (
    <form className="container m-5" onSubmit={formik.handleSubmit}>
      <div className="row">
        <div className="col-12">
          <h4>Novo dispositivo</h4>
        </div>
      </div>
      <div className="row">
        <div className="col-12">
          <label htmlFor="deviceName">Nome do recurso</label>
          <input
            id="deviceName"
            name="deviceName"
            type="text"
            onChange={formik.handleChange}
            value={formik.values.deviceName}
          />
        </div>
      </div>
      <div className="row">
        <div className="col-12">
          <label htmlFor="resourceType">Tipo do recurso</label>
          <select name="resourceType">
            {
              classes.length > 0 ? classes.map((ontologyClass) =>
                <option value={ontologyClass.hasUri}>{ontologyClass.hasUri}</option>
              )
                :
                <option value={0}>Não foram encontradas classes</option>
            }
          </select>
        </div>
      </div>
      <div className="row">
        <div className="col-12">
          <button type="submit">Criar</button>
        </div>
      </div>
      <div className="row">
        <div className="col-12">

        </div>
      </div>
    </form>
  );
};

export default NewIndividualForm;