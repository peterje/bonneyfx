<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
    <xsl:attribute-set name="myBorder">
        <xsl:attribute name="border">solid 0.1mm black</xsl:attribute>
    </xsl:attribute-set>
    <xsl:template match="sale">

        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="simpleA4" page-height="29.7cm" page-width="21cm" margin-top="2cm"
                                       margin-bottom="2cm" margin-left="2cm" margin-right="2cm" reference-orientation="90">
                    <fo:region-body margin-top="2cm"/>
                    <fo:region-before extent="2cm"/>
                    <fo:region-after extent="2cm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="simpleA4">
                <fo:static-content flow-name="xsl-region-after">
                    <fo:block font-weight="bold"> Commission Summary: </fo:block>
                    <fo:table width="100%">
                        <fo:table-column column-number="1"/>
                        <fo:table-column column-number="2"/>
                        <fo:table-column column-number="3"/>
                        <fo:table-header font-weight="bold">
                            <fo:table-row>
                                <fo:table-cell>
                                    <fo:block>Director</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>Split</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>Total Commission</fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-header>
                        <fo:table-body>
                            <xsl:for-each select="salesGroup/primaryServiceDirector">
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="./name"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="concat(string(./split * 100),'%')"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="./commission"/>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </xsl:for-each>
                            <xsl:for-each select="//salesGroup/secondaryServiceDirectors/*">
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="./name"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="concat(string(./split * 100),'%')"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="./commission"/>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </xsl:for-each>
                        </fo:table-body>
                    </fo:table>
                </fo:static-content>
                <fo:static-content flow-name="xsl-region-before">
                    <fo:table>
                        <fo:table-body>
                            <fo:table-row>
                                <fo:table-cell>
                                    <fo:block font-size="14pt" font-weight="bold" space-after="5mm">Bonney Watson Sales Report
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:table>
                                        <fo:table-body>
                                            <fo:table-row>
                                                <fo:table-cell xsl:use-attribute-sets="myBorder" height="1cm" display-align="center">
                                                    <fo:block text-align="center">Primary FSD</fo:block>
                                                </fo:table-cell>
                                                <fo:table-cell xsl:use-attribute-sets="myBorder" height="1cm">
                                                    <fo:block></fo:block>
                                                </fo:table-cell>
                                            </fo:table-row>
                                        </fo:table-body>
                                    </fo:table>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:table>
                                        <fo:table-body>
                                            <fo:table-row xsl:use-attribute-sets="myBorder" height="1cm" display-align="center" text-align="center">
                                                <fo:table-cell>
                                                    <fo:block>Manager Approval</fo:block>
                                                </fo:table-cell>
                                                <fo:table-cell xsl:use-attribute-sets="myBorder">
                                                    <fo:block></fo:block>
                                                </fo:table-cell>
                                            </fo:table-row>
                                        </fo:table-body>
                                    </fo:table>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-body>
                    </fo:table>
                </fo:static-content>

                <fo:flow flow-name="xsl-region-body">
                        <fo:block font-size="12pt" font-family="Helvetica">
                            <fo:table text-align="center" space-after="7mm">
                                <fo:table-header>
                                    <fo:table-row font-weight="bold">
                                        <fo:table-cell xsl:use-attribute-sets="myBorder" >
                                            <fo:block>Primary FSD</fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell xsl:use-attribute-sets="myBorder">
                                            <fo:block>Purchaser</fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell xsl:use-attribute-sets="myBorder">
                                            <fo:block>Recipient</fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell xsl:use-attribute-sets="myBorder">
                                            <fo:block>Date</fo:block>
                                        </fo:table-cell>
                                    </fo:table-row>
                                </fo:table-header>
                                <fo:table-body>
                                    <fo:table-row>
                                        <fo:table-cell xsl:use-attribute-sets="myBorder">
                                            <fo:block>
                                                <xsl:value-of select="/sale/salesGroup/primaryServiceDirector/name"/>
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell xsl:use-attribute-sets="myBorder">
                                            <fo:block>
                                                <xsl:value-of select="/sale/purchaser/name"/>
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell xsl:use-attribute-sets="myBorder">
                                            <fo:block>
                                                <xsl:value-of select="/sale/recipient/name"/>
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell xsl:use-attribute-sets="myBorder">
                                            <fo:block>
                                                <xsl:value-of select="document(&apos;http://xobjex.com/service/date.xsl&apos;)/date/utc/@rfc-822"/>
                                            </fo:block>
                                        </fo:table-cell>
                                    </fo:table-row>
                                </fo:table-body>
                            </fo:table>

                            <fo:table>
                                <xsl:call-template name="itemHeader"/>
                                <fo:table-body>
                                    <fo:table-row>
                                        <fo:table-cell>
                                            <fo:block></fo:block>
                                        </fo:table-cell>
                                    </fo:table-row>
                                </fo:table-body>
                            </fo:table>
                            <xsl:if test="itemsSold/atNeed">
                                <fo:block space-after="7mm">
                                    <fo:block font-weight="bold"> At Need: </fo:block>
                                    <fo:table table-layout="fixed" width="100%" border-collapse="separate">
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
                                    <fo:table table-layout="fixed" width="100%">
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

    <xsl:template match="itemsSold/*">
        <fo:table-row>
            <fo:table-cell >
                <fo:block>
                    <xsl:value-of select="substring(product, 0, 4)"/>
                </fo:block>
            </fo:table-cell>

            <fo:table-cell>
                <fo:block>
                    <xsl:value-of select="substring(boardValue, 4)"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell>
                <xsl:choose>
                    <xsl:when test="plotcode">
                        <fo:block>
                            <xsl:value-of select="plotcode"/>
                        </fo:block>
                    </xsl:when>
                    <xsl:otherwise>
                        <fo:block>
                            NA
                        </fo:block>
                    </xsl:otherwise>
                </xsl:choose>
            </fo:table-cell>
            <fo:table-cell>
                <xsl:choose>
                    <xsl:when test="fullPay">
                        <fo:block>
                            <xsl:value-of select="fullPay"/>
                        </fo:block>
                    </xsl:when>
                    <xsl:otherwise>
                        <fo:block>
                            NA
                        </fo:block>
                    </xsl:otherwise>
                </xsl:choose>
            </fo:table-cell>
            <fo:table-cell>
                <xsl:choose>
                    <xsl:when test="leadCode">
                        <fo:block>
                            <xsl:value-of select="leadCode"/>
                        </fo:block>
                    </xsl:when>
                    <xsl:otherwise>
                        <fo:block>
                            Company
                        </fo:block>
                    </xsl:otherwise>
                </xsl:choose>
            </fo:table-cell>
            <fo:table-cell>
                <xsl:choose>
                    <xsl:when test="age">
                        <fo:block>
                            <xsl:value-of select="age"/>
                        </fo:block>
                    </xsl:when>
                    <xsl:otherwise>
                        <fo:block>
                            NA
                        </fo:block>
                    </xsl:otherwise>
                </xsl:choose>
            </fo:table-cell>
            <fo:table-cell>
                <xsl:choose>
                    <xsl:when test="payPlan">
                        <fo:block>
                            <xsl:value-of select="payPlan"/>
                        </fo:block>
                    </xsl:when>
                    <xsl:otherwise>
                        <fo:block>
                            NA
                        </fo:block>
                    </xsl:otherwise>
                </xsl:choose>
            </fo:table-cell>
            <fo:table-cell>
                <fo:block>
                    <xsl:value-of select="concat(string(commissionRate*100),'%')"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell>
                <fo:block>
                    <xsl:value-of select="commission"/>
                </fo:block>
            </fo:table-cell>
        </fo:table-row>
    </xsl:template>

    <xsl:template name="itemHeader">
        <fo:table-column column-number="1"/>
        <fo:table-column column-number="2"/>
        <fo:table-column column-number="3"/>
        <fo:table-column column-number="4"/>
        <fo:table-column column-number="5"/>
        <fo:table-column column-number="6"/>
        <fo:table-column column-number="7"/>
        <fo:table-column column-number="8"/>
        <fo:table-column column-number="9"/>

        <fo:table-header font-weight="bold">
            <fo:table-row>
                <fo:table-cell>
                    <fo:block>Product</fo:block>
                </fo:table-cell>
                <fo:table-cell>
                    <fo:block>Board Value</fo:block>
                </fo:table-cell>
                <fo:table-cell>
                    <fo:block>Plot</fo:block>
                </fo:table-cell>
                <fo:table-cell>
                    <fo:block>Full Pay</fo:block>
                </fo:table-cell>
                <fo:table-cell>
                    <fo:block>Lead Code</fo:block>
                </fo:table-cell>
                <fo:table-cell>
                    <fo:block>Age</fo:block>
                </fo:table-cell>
                <fo:table-cell>
                    <fo:block>Pay Plan</fo:block>
                </fo:table-cell>
                <fo:table-cell>
                    <fo:block>Comm. Rate</fo:block>
                </fo:table-cell>
                <fo:table-cell>
                    <fo:block>Commission</fo:block>
                </fo:table-cell>
            </fo:table-row>
        </fo:table-header>
    </xsl:template>

</xsl:stylesheet>