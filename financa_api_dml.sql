--USUÁRIOS

INSERT INTO public.usuarios(
	id, nome_completo, login, senha, perfil)
	VALUES (0, 'Kamily Claudino Gomes', 'kcgomes', 1234567, 'GESTOR');

INSERT INTO public.usuarios(
	id, nome_completo, login, senha, perfil)
	VALUES (1, 'Sofia Raufino Martins', 'srmartins', 1324579, 'GESTOR');

INSERT INTO public.usuarios(
	id, nome_completo, login, senha, perfil)
	VALUES (2, 'Cleber Machado Silva', 'cmsilva', 3917873, 'FORNECEDOR');

INSERT INTO public.usuarios(
	id, nome_completo, login, senha, perfil)
	VALUES (3, 'Ruan Lopes Damasco', 'rldamasco', 5789855, 'FORNECEDOR');

INSERT INTO public.usuarios(
	id, nome_completo, login, senha, perfil)
	VALUES (4, 'Rafael Rubens Muller', 'rrmuller', 4593521, 'FORNECEDOR');

--FORNECEDORES

INSERT INTO public.fornecedores(
	id, razao_social, nome_fantasia, cnpj, login, senha)
	VALUES (0, 'SERVITEC INDUSTRIA E COMERCIO LTDA', 'SERVITECH Equipamentos Cerâmicos', '23.258.984/0001-00', 'kcgomes', 1234567);

INSERT INTO public.fornecedores(
	id, razao_social, nome_fantasia, cnpj, login, senha)
	VALUES (1, 'LACTICINIOS TIROL LTDA', 'Lacticinios Tirol', '86.450.088/0001-69', 'srmartins', 1324579);

INSERT INTO public.fornecedores(
	id, razao_social, nome_fantasia, cnpj, login, senha)
	VALUES (2, 'LOJAS DE DEPARTAMENTOS MILIUM LTDA', 'Milium Tem de Tudo', '93.470.695/0001-56', 'cmsilva', 3917873);

INSERT INTO public.fornecedores(
	id, razao_social, nome_fantasia, cnpj, login, senha)
	VALUES (3, 'FLAYBER CARE CONCEPT LTDA', 'Flayber Odontologia', '07.077.819/0001-04', 'rldamasco', 5789855);

INSERT INTO public.fornecedores(
	id, razao_social, nome_fantasia, cnpj, login, senha)
	VALUES (4, 'ATACADO E VAREJO SAO MANOEL LTDA', 'Comércio São Manoel', '39.247.767/0001-55', 'rrmuller', 4593521);

--TÍTULOS

INSERT INTO public.titulos(
	id, valor, data_vencimento, nome_banco, descricao, fornecedor_id)
	VALUES (0, 1533.01, '2022-07-04', 'Bradesco', 'Prestação de suporte para equipamentos do mercado cerâmico', 0);

INSERT INTO public.titulos(
	id, valor, data_vencimento, nome_banco, descricao, fornecedor_id)
	VALUES (1, 941.88, '2022-08-12', 'Santander', 'Produção de Lacticínios', 1);

INSERT INTO public.titulos(
	id, valor, data_vencimento, nome_banco, descricao, fornecedor_id)
	VALUES (2, 321.00, '2023-01-01', 'Banco do Brasil', 'Atacado e varejo', 2);

INSERT INTO public.titulos(
	id, valor, data_vencimento, nome_banco, descricao, fornecedor_id)
	VALUES (3, 1700.00, '2043-01-27', 'Santander', 'Implante de próteses dentárias', 3);

INSERT INTO public.titulos(
	id, valor, data_vencimento, nome_banco, descricao, fornecedor_id)
	VALUES (4, 89.00, '2023-07-31', 'Santander', 'Comércio geral de produtos', 4);