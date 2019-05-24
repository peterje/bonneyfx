<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
    <xsl:template match="/">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="simpleA4" page-height="29.7cm" page-width="21cm" margin-top="2cm"
                                       margin-bottom="2cm" margin-left="2cm" margin-right="2cm">
                    <fo:region-body/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="simpleA4">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-size="16pt" font-weight="bold" space-after="5mm">Bonney Watson Sales Report
                    </fo:block>
                    <fo:block font-size="10pt">
                        <fo:table table-layout="fixed" width="100%" border-collapse="separate">
                            <fo:table-column column-width="20%"/>
                            <fo:table-column column-width="20%"/>
                            <fo:table-column column-width="20%"/>
                            <fo:table-column column-width="20%"/>
                            <fo:table-body>
                                <xsl:apply-templates select="itemsSold/com.edmointel.bonneyfx.model.AtNeedItem"/>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
    <xsl:template match="itemsSold/com.edmointel.bonneyfx.model.AtNeedItem">
        <fo:root>
            <fo:table-row>
                <fo:table-cell>
                    <fo:block>Product:
                        <xsl:value-of select="product"/>
                    </fo:block>
                </fo:table-cell>

                <fo:table-cell>
                    <fo:block>
                        Board Value:
                        <xsl:value-of select="boardValue"/>
                    </fo:block>
                </fo:table-cell>
                <fo:table-cell>
                    <fo:block>commissionRate:
                        <xsl:value-of select="commissionRate"/>
                    </fo:block>
                </fo:table-cell>
                <fo:table-cell>
                    <fo:block>commission:
                        <xsl:value-of select="commission"/>
                    </fo:block>
                </fo:table-cell>
            </fo:table-row>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>