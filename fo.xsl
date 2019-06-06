<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
    <xsl:template match="sale">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="simpleA4" page-height="29.7cm" page-width="21cm" margin-top="2cm"
                                       margin-bottom="2cm" margin-left="2cm" margin-right="2cm" reference-orientation="90">
                    <fo:region-body/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="simpleA4">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-size="16pt" font-weight="bold" space-after="5mm">Bonney Watson Sales Report
                    </fo:block>

                        <fo:block font-size="12pt" font-family="Helvetica">

                            <xsl:if test="itemsSold/atNeed">
                                <fo:block space-after="7mm">
                                    <fo:block font-weight="bold"> At Need: </fo:block>
                                    <fo:table table-layout="fixed" width="100%" border-collapse="separate">
                                        <fo:table-column column-width="20%"/>
                                        <fo:table-column column-width="20%"/>
                                        <fo:table-column column-width="20%"/>
                                        <fo:table-column column-width="20%"/>
                                        <fo:table-body>
                                            <xsl:for-each select="itemsSold/atNeed">
                                                <xsl:apply-templates select="."/>
                                            </xsl:for-each>
                                        </fo:table-body>
                                    </fo:table>
                                </fo:block>
                            </xsl:if>

                            <xsl:if test="itemsSold/preNeed">
                                <fo:block space-after="7mm">
                                <fo:block font-weight="bold"> Pre Need: </fo:block>
                                <fo:table table-layout="fixed" width="100%" border-collapse="separate">
                                    <fo:table-column column-width="20%"/>
                                    <fo:table-column column-width="20%"/>
                                    <fo:table-column column-width="20%"/>
                                    <fo:table-column column-width="20%"/>
                                    <fo:table-body>
                                        <xsl:for-each select="itemsSold/preNeed">
                                            <xsl:apply-templates select="."/>
                                        </xsl:for-each>
                                    </fo:table-body>
                                </fo:table>
                                </fo:block>
                            </xsl:if>


                            <xsl:if test="itemsSold/forethought">
                                <fo:block space-after="7mm">
                                    <fo:block font-weight="bold"> Forethought: </fo:block>
                                    <fo:table table-layout="fixed" width="100%" border-collapse="separate">
                                        <fo:table-column column-width="20%"/>
                                        <fo:table-column column-width="20%"/>
                                        <fo:table-column column-width="20%"/>
                                        <fo:table-column column-width="20%"/>
                                        <fo:table-body>
                                            <xsl:for-each select="itemsSold/forethought">
                                                <xsl:apply-templates select="."/>
                                            </xsl:for-each>
                                        </fo:table-body>
                                    </fo:table>
                                </fo:block>
                            </xsl:if>

                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
    <xsl:template match="itemsSold/atNeed">
            <fo:table-row>
                <fo:table-cell>
                    <fo:block>
                        <xsl:value-of select="product"/>
                    </fo:block>
                </fo:table-cell>

                <fo:table-cell>
                    <fo:block>
                        <xsl:value-of select="boardValue"/>
                    </fo:block>
                </fo:table-cell>
                <fo:table-cell>
                    <fo:block>
                        <xsl:value-of select="commissionRate"/>
                    </fo:block>
                </fo:table-cell>
                <fo:table-cell>
                    <fo:block>
                        <xsl:value-of select="commission"/>
                    </fo:block>
                </fo:table-cell>
            </fo:table-row>
    </xsl:template>

    <xsl:template match="itemsSold/forethought">
        <fo:table-row>
            <fo:table-cell >
                <fo:block>
                    <xsl:value-of select="product"/>
                </fo:block>
            </fo:table-cell>

            <fo:table-cell>
                <fo:block>
                    <xsl:value-of select="boardValue"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell>
                <fo:block>
                    <xsl:value-of select="commissionRate"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell>
                <fo:block>
                    <xsl:value-of select="commission"/>
                </fo:block>
            </fo:table-cell>
        </fo:table-row>
    </xsl:template>

    <xsl:template match="itemsSold/preNeed">
        <fo:table-row>
            <fo:table-cell>
                <fo:block>
                    <xsl:value-of select="product"/>
                </fo:block>
            </fo:table-cell>

            <fo:table-cell>
                <fo:block>
                    <xsl:value-of select="boardValue"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell>
                <fo:block>
                    <xsl:value-of select="commissionRate"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell>
                <fo:block>
                    <xsl:value-of select="commission"/>
                </fo:block>
            </fo:table-cell>
        </fo:table-row>
    </xsl:template>
</xsl:stylesheet>