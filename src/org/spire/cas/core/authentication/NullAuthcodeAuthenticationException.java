package org.spire.cas.core.authentication;

import org.jasig.cas.authentication.RootCasException;

/**
 * The exception to throw when we know the authcode is null
 * 
 * @author Scott Battaglia
 * @version $Revision$ $Date$
 * @since 3.0
 */
public class NullAuthcodeAuthenticationException extends RootCasException {

	/** Serializable ID for unique id. */
	private static final long serialVersionUID = 5501212207531289993L;

	/** Code description. */
	public static final String CODE = "required.authcode";

	/**
	 * Constructs a TicketCreationException with the default exception code.
	 */
	public NullAuthcodeAuthenticationException() {
		super(CODE);
	}

	/**
	 * Constructs a TicketCreationException with the default exception code and
	 * the original exception that was thrown.
	 * 
	 * @param throwable
	 *            the chained exception
	 */
	public NullAuthcodeAuthenticationException(final Throwable throwable) {
		super(CODE, throwable);
	}
}