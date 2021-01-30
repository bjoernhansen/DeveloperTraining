<?xml version="1.0" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">


    <xsl:variable name="test" select="'Humd'"/>

    <xsl:template match="/movie-collection">
        <html>
            <body>
                <table border="1">

                    <tr>
                        <th><xsl:value-of select="$test"/></th>
                        <th><xsl:value-of select="'Genre'"/></th>
                        <th><xsl:value-of select="'Direktor'"/></th>
                    </tr>

                    <xsl:for-each select="movie">
                        <xsl:sort select="title" order="descending"/>
                        <tr>
                            <td><xsl:value-of select="title"/></td>
                            <td><xsl:value-of select="genre"/></td>
                            <td><xsl:value-of select="director/@name"/></td>
                        </tr>
                    </xsl:for-each>



                </table>

            </body>
        </html>

    </xsl:template>
</xsl:stylesheet>