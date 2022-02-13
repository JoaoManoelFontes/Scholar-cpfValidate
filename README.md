<h1>Java Project: Cpf Validate</h1>
<h2>Mostra se o cpf que o usuário colocou é válido ou não</h2>
<br/>
<h2> Métodos: </h2>
<ul>
    <li>
    <h3>Main:</h3>
    <p>Recebe o cpf que o usuário digitou com a biblioteca <i>Java.util.Scanner</i> e armazena em uma String para mandar o método <i>validate</i> verificá-la e retornar um boolean true(Se o cpf for válido) ou false(se o cpf for inválido).</p>
    </li>
    <hr/>
    <li>
    <h3>Validate</h3>
    <p>Recebe a String contendo o cpf faz algumas verificações.</p>
    <p>tira os caracteres do cpf deixando somente os números e chama o método <i>isNumber</i> para verificar se todos os caracteres que sobraram são números.</p>
    <p>confere o comprimento da String só com os números, para ver se não está faltando nenhum.</p>
    <p>convoca o método <i>validateChars</i> para verificar se não está faltando nenhum dos caracteres que um cpf necessita ("." ou "-")</p>
    <p>chama os métodos <i>validateDigit</i> para conferir se os digitos verificadores (ultimos 2 digitos) batem com a conta de validação de cpf e o <i>validateSameNumbers</i> para ver se os números do cpf estão todos iguais (ex:000.000.000-00), pois seria inválido</p>
    </li>
    <hr/>
    <li>
    <h3>validateChars</h3>
    <p>Verifica, usando o <i>indexOf()</i> e o <i>substring()</i> se está faltando algum caractere tirando os números ("." ou "-") ou se esses caracteres estão na posição errada.</p>
    </li>
    <hr/>
    <li>
    <h3>validateDitig</h3>
    <p>Confere se os digitos verificadores (últimos digitos) batem com o cálculo de validação de cpf: <br/>
    Pega os 9 primeiros números do cpf e multiplica cada algarismo em uma sequência de 1 a 9 e soma todos os resultados. Logo após divide essa soma por 11, o resto da divisão é o primeiro digito (se o resultado for 10, usa-se o 0).<br/>
    Para encontrar o segundo digito, pega os 9 números e adciona o primeiro digito na ultima posição e faz a mesma multiplicação, agora começando do 0 ao 9. O resto da divisão por 11 é o segundo digito.
    </p>
    </li>
    <hr/>
    <li>
    <h3>validateSameNumbers</h3>
    <p>Serve para verificar se os números que o usuário inseriu são todos iguais, tornando assim o cpf inválido, porém o cálculo dos digitos verificadores dá esse cpf como válido, então precisa ser verificado a parte.</p>
    </li>
    <hr/>
    <li>
    <h3>isDouble</h3>
    <p>Método que mostra se a String cpf pode ser passada para double com o método <i>parseDouble()</i>, ou seja, vai retornar false se não poder passar essa String para double.</p>
    </li>
</ul>
