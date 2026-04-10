import xml.etree.ElementTree as ET

tree = ET.parse('/opt/openbravo/carnidem/modules/ec.com.sidesoft.carnidem.production.maintenance/src/ec/com/sidesoft/carnidem/production/maintenance/ad_reports/scma_maintenancemain.jrxml')
root = tree.getroot()

# Register namespace to keep the prefix empty (or handle namespaces properly)
ET.register_namespace('', 'http://jasperreports.sourceforge.net/jasperreports')
ET.register_namespace('xsi', 'http://www.w3.org/2001/XMLSchema-instance')

ns = {'j': 'http://jasperreports.sourceforge.net/jasperreports'}

# 1. Fix observaciones text field to stretch width overflow
# find the textField holding $F{observaciones}
for tf in root.findall('.//j:textField', ns):
    exp = tf.find('j:textFieldExpression', ns)
    if exp is not None and exp.text is not None and 'observaciones' in exp.text:
        tf.set('isStretchWithOverflow', 'true')
        
# 2. Add positionType="Float" to all reportElements that have y > 26 in the first detail band.
# detail band 1 is the first band inside <detail>
bands = root.findall('.//j:detail/j:band', ns)
if len(bands) > 0:
    band1 = bands[0]
    for element in band1:
        re = element.find('j:reportElement', ns)
        if re is not None:
            y_str = re.get('y')
            if y_str is not None:
                if int(y_str) > 26:
                    re.set('positionType', 'Float')

# 3. Add positionType="Float" to all reportElements that have y > 147 in the second detail band.
if len(bands) > 1:
    band2 = bands[1]
    for element in band2:
        re = element.find('j:reportElement', ns)
        if re is not None:
            y_str = re.get('y')
            if y_str is not None:
                if int(y_str) > 147:
                    re.set('positionType', 'Float')

# 4. Fix the bug: Solución Definitiva uses $F{solucion_temporal} instead of $F{solucion_definitiva}
# Find the textField at y=126 and x=482 in band1
if len(bands) > 0:
    for tf in bands[0].findall('.//j:textField', ns):
        re = tf.find('j:reportElement', ns)
        if re is not None and re.get('y') == '126' and re.get('x') == '482':
            exp = tf.find('j:textFieldExpression', ns)
            if exp is not None and exp.text == '<![CDATA[$F{solucion_temporal}]]>':
                exp.text = '<![CDATA[$F{solucion_definitiva}]]>'

tree.write('/opt/openbravo/carnidem/modules/ec.com.sidesoft.carnidem.production.maintenance/src/ec/com/sidesoft/carnidem/production/maintenance/ad_reports/scma_maintenancemain.jrxml', encoding='UTF-8', xml_declaration=True)
print("File successfully modified.")
