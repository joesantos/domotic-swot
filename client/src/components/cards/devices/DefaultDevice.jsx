import React from "react";

// async function upTemperature(url, id, update) {
//   await fetch(`http://localhost:8080/${url}?id=${id}`);
//   update();
// }

// async function downTemperature(url, id, update) {
//   await fetch(`http://localhost:8080/${url}?id=${id}`);
//   update();
// }

function cleanUri(uri) {
  let splitted = uri.split("#");
  return splitted[1];
}

export default function DefaultDevice(props) {
  return (
    <div className="card p-2">
      <div className="row">
        <div className="col-12">
          <h3>{cleanUri(props.device.hasUri)}</h3>
        </div>
      </div>
    </div>
  );
}

function removeUriPart(uri) {
  let hashPosition = uri.indexOf("#");
  return uri.slice(hashPosition);
}
