OB.SSPTDL = OB.SSPTDL || {};

OB.SSPTDL.Process = {
  execute: function (params, view) {
    var i, selection = params.button.contextView.viewGrid.getSelectedRecords(),
      orders = [],
      callback;

    callback = function (rpcResponse, data, rpcRequest) {
      // show result
      isc.say('Actualizado ubicación Actual');

      // refresh the whole grid after executing the process
      params.button.contextView.viewGrid.refreshGrid();
    };

    for (i = 0; i < selection.length; i++) {
      orders.push(selection[i].id);
    }

    // Llama a obtenerUbicacion para obtener la latitud y longitud
    obtenerUbicacion(function (latitude, longitude) {
      // Agrega la latitud y longitud a los parámetros
      params.latitude = latitude;
      params.longitude = longitude;


      OB.RemoteCallManager.call('ec.com.sidesoft.payroll.telecommuting.dialing.action_button.Get_Location_GPS', {
        orders: orders,
        action: params.action,
        gps_longitude: longitude,
        gps_latitude: latitude
      }, {}, callback);

    });


  },

  sum: function (params, view) {
    params.action = 'sum';
    OB.SSPTDL.Process.execute(params, view);
  },

  subtract: function (params, view) {
    params.action = 'subtract';
    OB.SSPTDL.Process.execute(params, view);
  }
};


/*
function obtenerUbicacion(callback) {
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(function(position) {
      var latitude = position.coords.latitude;
      var longitude = position.coords.longitude;
            
      // Llama a la función de retorno con la latitud y longitud
      callback(latitude, longitude);
    }, function(error) {
      console.error('Error al obtener la ubicación: ' + error.message);
    });
  } else {
    console.error('Geolocalización no es compatible con este navegador.');
  }
}
*/


function obtenerUbicacion(callback) {
  navigator.geolocation.getCurrentPosition(function (location) {
    var latitude = location.coords.latitude;
    var longitude = location.coords.longitude;

    // Crear el elemento <script> con el src como una variable
    var v_src = "https://maps.googleapis.com/maps/api/js?key=AIzaSyDuBEidKGDuQo7Bzf1uRg47MPaRRlEesw0";
    var scriptElement = document.createElement('script');
    scriptElement.src = v_src;
    callback(latitude, longitude);
    /*
      OB.RemoteCallManager.call('ec.com.sidesoft.payroll.telecommuting.dialing.action_button.Get_Location_GPS', {
        orders: orders,
        action: params.action,
        gps_longitude: longitude,
        gps_latitude: latitude
      }, {}, callback);
      */

  });
};

