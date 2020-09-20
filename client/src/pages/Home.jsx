import React, { useState, useEffect } from 'react';
import ArCondicionado from '../components/cards/devices/ArCondicionado';

function Home() {
  const [devices, setDevices] = useState([]);

  async function getDevices() {
    const response = await fetch("http://localhost:8080/ArCondicionado/list");
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
          <div className='container'>
            {item.hasTemperature ?
              <ArCondicionado item={item} update={getDevices} />
              :
              <div>Dispositivo não definido na aplicação {JSON.stringify(item)}</div>
            }
          </div>
        )
          :
          <div>Não há dispositivos disponíveis</div>
      }
    </div>
  );
}

export default Home;