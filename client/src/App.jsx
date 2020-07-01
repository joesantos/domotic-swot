import React, { useState, useEffect } from 'react';

function App() {
  const [devices, setDevices] = useState([]);

  async function getDevices() {
    const response = await fetch("http://localhost:8080/ac/list-ac");
    const responseJson = await response.json();
    setDevices(responseJson)
  }

  useEffect(() => {
    if (devices.length === 0) getDevices();
  })


  return (
    <div className="App">
      {
        devices.length > 0 ? devices.map((item) =>
          <div>
            <h3>{item.hasName}</h3>
            <p>Temperatura: {item.hasTemperature}°C</p>
            <div>{item.services.map(service =>
              <div onClick={async () => {
                await fetch(`http://localhost:8080${service}?id=${item.hasId}`);
                await getDevices()
              }}>
                <span>{service}</span>
              </div>)}
            </div>
          </div>
        )
          :
          <div>Não há dispositivos disponíveis</div>
      }
    </div>
  );
}

export default App;