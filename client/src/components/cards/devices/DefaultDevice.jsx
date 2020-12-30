import React from "react";

async function upTemperature(url, id, update) {
  await fetch(`http://localhost:8080/${url}?id=${id}`);
  update();
}

async function downTemperature(url, id, update) {
  await fetch(`http://localhost:8080/${url}?id=${id}`);
  update();
}

export default function DefaultDevice({ item, update }) {
  return (
    <div className="card p-2">
      <div className="row">
        <div className="col-12"></div>
      </div>
    </div>
  );
}

function removeUriPart(uri) {
  let hashPosition = uri.indexOf("#");
  return uri.slice(hashPosition);
}
