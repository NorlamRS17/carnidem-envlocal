/*
 * Hook para agregar el email del Business Partner al order antes de imprimir
 * El email viene del campo eEIEmail que se sincroniza desde el servidor
 * Usa OB.DS.Process para obtener el email del tercero desde el servidor sin recargar el POS
 */
/*global OB */

(function () {
  'use strict';

  OB.UTIL.HookManager.registerHook('OBPRINT_PrePrint', function (args, callbacks) {
    var order = args.order;
    if (!order) {
      OB.UTIL.HookManager.callbackExecutor(args, callbacks);
      return;
    }

    var bp = order.get('bp');
    var bpId = null;
    
    // Obtener el ID del tercero
    if (bp) {
      if (bp.get && bp.get('id')) {
        bpId = bp.get('id');
      } else if (bp.id) {
        bpId = bp.id;
      } else if (bp.attributes && bp.attributes.id) {
        bpId = bp.attributes.id;
      }
    }
    
    // Si no hay ID, intentar obtener email del bp actual
    if (!bpId) {
      var email = null;
      if (bp) {
        if (bp.attributes && bp.attributes.eEIEmail) {
          email = bp.attributes.eEIEmail;
        } else if (bp.get && bp.get('eEIEmail')) {
          email = bp.get('eEIEmail');
        }
      }
      
      if (email) {
        order.set('bpEmail', email);
      }
      
      OB.UTIL.HookManager.callbackExecutor(args, callbacks);
      return;
    }
    
    // Obtener el email del tercero desde el servidor usando OB.DS.Process
    // Esto NO recarga el POS, solo hace una llamada al servidor
    var serverCall = new OB.DS.Process('ec.com.sidesoft.pos.custom.print.models.GetBusinessPartnerEmail');
    serverCall.exec({
      bpId: bpId
    }, function (data, message) {
      // Success callback
      var email = null;
      
      if (data && data.email) {
        email = data.email;
      }
      
      // Si no se obtuvo email del servidor, intentar del bp local
      if (!email && bp) {
        if (bp.attributes && bp.attributes.eEIEmail) {
          email = bp.attributes.eEIEmail;
        } else if (bp.get && bp.get('eEIEmail')) {
          email = bp.get('eEIEmail');
        }
      }
      
      if (email) {
        order.set('bpEmail', email);
      }
      
      // Continuar con el flujo normal
      OB.UTIL.HookManager.callbackExecutor(args, callbacks);
    }, function (error) {
      var email = null;
      if (bp) {
        if (bp.attributes && bp.attributes.eEIEmail) {
          email = bp.attributes.eEIEmail;
        } else if (bp.get && bp.get('eEIEmail')) {
          email = bp.get('eEIEmail');
        }
      }
      
      if (email) {
        order.set('bpEmail', email);
      }
      
      OB.UTIL.HookManager.callbackExecutor(args, callbacks);
    });
  });
}());

