import React, { useState, useEffect } from "react";
import ArCondicionado from "../components/cards/devices/ArCondicionado";
import DefaultDevice from "../components/cards/devices/DefaultDevice";

function Home() {
  const [devices, setDevices] = useState([]);

  async function getDevices() {
    const response = await fetch(
      "http://localhost:8080/feature-of-interest/list/all"
    );
    const responseJson = await response.json();
    setDevices(responseJson);
  }

  useEffect(() => {
    if (devices.length === 0) getDevices();
  });

  return (
    <div className="App">
      {devices.length > 0 ? (
        devices.map((item) => <DefaultDevice device={item}></DefaultDevice>)
      ) : (
        <div>Não há dispositivos disponíveis</div>
      )}
    </div>
  );
}

export default Home;
