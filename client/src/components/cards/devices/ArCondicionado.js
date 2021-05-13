import React from 'react'

async function upTemperature(url, id, update){
    await fetch(`http://localhost:8080/${url}?id=${id}`);
    update();
}

async function downTemperature(url, id, update){
    await fetch(`http://localhost:8080/${url}?id=${id}`);
    update();
}

export default ({ item, update }) => <div className='card p-2'>
    <div className='row'>
        <div className='col-12'>
            <p>{item.hasName}</p>
        </div>
        <div className='col-8'>
            <h2>{item.hasTemperature}°C</h2>
        </div>
        <div className='col-4'>
            {item.services.map((service) =>
                service.includes("aumentar") ?
                <div><i className="fas fa-plus-circle fa-2x" onClick={() => upTemperature(service, item.hasId, update)}/></div>
                    :
                    (service.includes("reduzir") ?
                        <div><i className="fas fa-minus-circle fa-2x" onClick={() => downTemperature(service, item.hasId, update)}/></div>
                        :
                        <div>{item.url} - Serviço ainda não definido na aplicação</div>
                    )
            )}
        </div>
    </div>
</div>

